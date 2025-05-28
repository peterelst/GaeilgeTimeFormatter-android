package peterelst.gaeilgetimeformatter

import java.util.*

@Suppress("unused", "SpellCheckingInspection")
object GaeilgeTimeFormatter {
    fun getIrishTimePhrase(calendar: Calendar = Calendar.getInstance()): String {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val nextHour = (hour + 1) % 24

        fun getFormattedHour(h: Int): String {
            val displayHour = if (h % 12 == 0) 12 else h % 12
            val hoursMap = mapOf(
                12 to "a dó dhéag",
                1 to "a haon",
                2 to "a dó",
                3 to "a trí",
                4 to "a ceathair",
                5 to "a cúig",
                6 to "a sé",
                7 to "a seacht",
                8 to "a hocht",
                9 to "a naoi",
                10 to "a deich",
                11 to "a haon déag"
            )
            return hoursMap[displayHour] ?: ""
        }

        fun getFormattedNextHour(h: Int): String {
            val displayHour = if (h % 12 == 0) 12 else h % 12
            val hoursMap = mapOf(
                12 to "a dó dhéag",
                1 to "a haon",
                2 to "a dó",
                3 to "a trí",
                4 to "a ceathair",
                5 to "a cúig",
                6 to "a sé",
                7 to "a seacht",
                8 to "a hocht",
                9 to "a naoi",
                10 to "a deich",
                11 to "a haon déag"
            )
            return hoursMap[displayHour] ?: ""
        }

        fun getFormattedMinutePhrase(m: Int): String {
            return when (m) {
                1 -> "aon nóiméad"
                2 -> "dhá nóiméad"
                3 -> "trí nóiméad"
                4 -> "ceithre nóiméad"
                in 5..14 -> {
                    val numbersMap = mapOf(
                        5 to "cúig", 6 to "sé", 7 to "seacht", 8 to "ocht", 9 to "naoi",
                        10 to "deich", 11 to "aon déag", 12 to "dó dhéag", 13 to "trí déag", 14 to "ceithre déag"
                    )
                    "${numbersMap[m]} nóiméad"
                }
                in 16..19 -> {
                    val numbersMap = mapOf(
                        16 to "sé déag", 17 to "seacht déag", 18 to "ocht déag", 19 to "naoi déag"
                    )
                    "${numbersMap[m]} nóiméad"
                }
                20 -> "fiche nóiméad"
                in 21..29 -> {
                    val unit = m % 10
                    val unitPhrase = when (unit) {
                        1 -> "aon"
                        2 -> "dhá"
                        3 -> "trí"
                        4 -> "ceithre"
                        5 -> "cúig"
                        6 -> "sé"
                        7 -> "seacht"
                        8 -> "ocht"
                        else -> "naoi"
                    }
                    "fiche is $unitPhrase nóiméad"
                }
                else -> ""
            }
        }

        return when {
            minute == 0 -> "Tá sé ${getFormattedHour(hour)} a chlog"
            minute == 15 -> "Tá sé ceathrú tar éis ${getFormattedHour(hour)}"
            minute == 30 -> "Tá sé leathuair tar éis ${getFormattedHour(hour)}"
            minute == 45 -> "Tá sé ceathrú chun ${getFormattedNextHour(nextHour)}"
            minute < 30 -> "Tá sé ${getFormattedMinutePhrase(minute)} tar éis ${getFormattedHour(hour)}"
            else -> {
                val toMinute = 60 - minute
                "Tá sé ${getFormattedMinutePhrase(toMinute)} chun ${getFormattedNextHour(nextHour)}"
            }
        }
    }
}
