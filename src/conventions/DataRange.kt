package conventions

class DateRange(override var start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {

            override fun next(): MyDate {
                val result = start
                start = start.nextDay()
                return result
            }

            override fun hasNext(): Boolean {
                return start <= endInclusive
            }
        }
    }
}
