import java.util.*

class DiceCounterCLI {
    fun main(){
        val scanner = Scanner(System.`in`)

        print("Enter the number of sides of the dice: ")
        val numSides = scanner.nextInt()

        print("Enter the number of dice rolls: ")
        val numRolls = scanner.nextInt()

        val rolls = IntArray(numRolls)

        for (i in 0 until numRolls) {
            print("Enter the result of roll ${i + 1}: ")

            var rollValue = scanner.nextInt()

            while(rollValue < 1 || rollValue > numSides){
                print("Invalid Dice roll. Pleas enter a valid value between 1 and $numSides: ")
                rollValue = scanner.nextInt()
            }

            rolls[i] = rollValue
        }
        scanner.close()

//        val diceValue = getDiceValueToCount(rolls)
//        val count = diceCounter(rolls, diceValue)
        val mean = calculateMean(rolls)
        val median = calculateMedian(rolls)
        val mode = calculateMode(rolls)
        val evenCount = countEvenNumbers(rolls)
        val oddCount = countOddNumbers(rolls)

        println("The mean is: $mean")
        println("The median is: $median")
        println("The mode is: $mode")
        println("The number of even numbers is: $evenCount")
        println("The number of odd numbers is: $oddCount")
    }

    private fun calculateMean(rolls: IntArray): Double {
        if(rolls.isEmpty()){
            return 0.0
        }
        var sum = 0
        for (roll in rolls){
            sum += roll
        }
        return sum.toDouble() / rolls.size
    }

    private fun calculateMedian(rolls: IntArray): Double {
        if(rolls.isEmpty()){
            return 0.0
        }
        rolls.sort()

        return if(rolls.size % 2 ==0){
            val middle1 = rolls.size / 2
            val middle2 = middle1 - 1
            (rolls[middle1] + rolls[middle2]).toDouble() / 2
        } else {
            rolls[rolls.size / 2].toDouble()
        }
    }

    private fun calculateMode(rolls: IntArray): Int {
        if(rolls.isEmpty()){
            return 0
        }

        val freqMap = HashMap<Int, Int>()
        var maxFrequency = 0
        var mode = 0

        for(roll in rolls){
            val frequency = freqMap.getOrDefault(roll, 0) + 1
            freqMap[roll] = frequency
            if(frequency > maxFrequency){
                maxFrequency = frequency
                mode = roll
            }
        }
        return mode
    }

    private fun countEvenNumbers(rolls: IntArray): Int {
        var evenCount = 0
        for (roll in rolls){
            if(roll % 2 == 0){
                evenCount++
            }
        }
        return evenCount
    }

    private fun countOddNumbers(rolls: IntArray): Int {
        var oddCount = 0
        for (roll in rolls){
            if(roll % 2 != 0){
                oddCount++
            }
        }
        return oddCount
    }
}

fun main(){
    val diceCounter = DiceCounterCLI()
    diceCounter.main()
}