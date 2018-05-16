package conventions

import java.time.Year
import java.util.*

data class MyDate(private val year: Int, private val month: Int, private val dayOfMonth: Int) : Comparable<MyDate> {

    operator fun plus(timeInterval: TimeInterval) = when {
        timeInterval == TimeInterval.YEAR -> addTimeIntervals(TimeInterval.YEAR, 1)
        timeInterval == TimeInterval.WEEK -> addTimeIntervals(TimeInterval.WEEK, 1)
        else -> addTimeIntervals(TimeInterval.DAY, 1)
    }

    operator fun plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    fun nextDay(): MyDate {
        return addTimeIntervals(TimeInterval.DAY, 1)
    }

    private fun addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
        val c = Calendar.getInstance()
        c.set(year, month, dayOfMonth)
        when (timeInterval) {
            TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
            TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
            TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
        }
        return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
    }
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int) {
    operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)
}
