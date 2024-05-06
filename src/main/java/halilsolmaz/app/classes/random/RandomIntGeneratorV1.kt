package halilsolmaz.app.classes.random

import kotlin.random.Random

class RandomIntGeneratorV1(private val mCount: Int, private val mMin: Int, private val mBound: Int, private val mRandom : Random = Random) : Iterable<Int> {
    private var mIndex = -1

    init {
        if (mCount <= 0 || mMin >= mBound)
            throw IllegalArgumentException("Invalid arguments")
    }

    override fun iterator(): Iterator<Int>
    {
        mIndex = -1

        return object : Iterator<Int> {
            override fun hasNext() = mIndex + 1 < mCount

            override fun next(): Int {
                if (!hasNext())
                    throw NoSuchElementException("No such element!...")

                ++mIndex

                return mRandom.nextInt(mMin, mBound)
            }
        }
    }
}