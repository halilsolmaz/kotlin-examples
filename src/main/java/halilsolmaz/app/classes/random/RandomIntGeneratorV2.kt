package halilsolmaz.app.classes.random

import kotlin.random.Random

class RandomIntGeneratorV2(private val mCount: Int, private val mMin: Int, private val mBound: Int, private val mRandom : Random = Random) : Iterable<Int> {
    init {
        if (mCount <= 0 || mMin >= mBound)
            throw IllegalArgumentException("Invalid arguments")
    }

    override fun iterator(): Iterator<Int>
    {
        var count = -1

        return object : Iterator<Int> {
            override fun hasNext() = count + 1 < mCount

            override fun next(): Int {
                if (!hasNext())
                    throw NoSuchElementException("No such element!...")

                ++count

                return mRandom.nextInt(mMin, mBound)
            }
        }
    }
}