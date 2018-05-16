package conventions

import java.util.*

data class MyDate(private val year: Int, private val month: Int, private val dayOfMonth: Int) : Comparable<MyDate> {

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

    enum class TimeInterval {
        DAY,
        WEEK,
        YEAR
    }
}