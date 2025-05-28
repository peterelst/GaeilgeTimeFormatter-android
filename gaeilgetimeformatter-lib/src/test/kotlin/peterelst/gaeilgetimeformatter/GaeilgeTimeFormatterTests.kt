package peterelst.gaeilgetimeformatter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("SpellCheckingInspection")
class GaeilgeTimeFormatterTests {
    private fun createCalendar(hour: Int, minute: Int): Calendar {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
            set(2024, Calendar.JANUARY, 1, hour, minute, 0)
        }
    }

    @Test fun testOnTheHour() {
        assertEquals("Tá sé a haon a chlog", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 0)))
        assertEquals("Tá sé a seacht a chlog", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(7, 0)))
        assertEquals("Tá sé a dó dhéag a chlog", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(12, 0)))
        assertEquals("Tá sé a dó dhéag a chlog", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(0, 0)))
        assertEquals("Tá sé a haon déag a chlog", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(23, 0)))
    }

    @Test fun testQuarterPast() {
        assertEquals("Tá sé ceathrú tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 15)))
        assertEquals("Tá sé ceathrú tar éis a deich", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(10, 15)))
        assertEquals("Tá sé ceathrú tar éis a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(0, 15)))
    }

    @Test fun testHalfPast() {
        assertEquals("Tá sé leathuair tar éis a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(2, 30)))
        assertEquals("Tá sé leathuair tar éis a haon déag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(11, 30)))
        assertEquals("Tá sé leathuair tar éis a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(12, 30)))
    }

    @Test fun testQuarterTo() {
        assertEquals("Tá sé ceathrú chun a ceathair", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(3, 45)))
        assertEquals("Tá sé ceathrú chun a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(23, 45)))
        assertEquals("Tá sé ceathrú chun a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(11, 45)))
    }

    @Test fun testMinutesPast() {
        assertEquals("Tá sé aon nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 1)))
        assertEquals("Tá sé dhá nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 2)))
        assertEquals("Tá sé trí nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 3)))
        assertEquals("Tá sé ceithre nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 4)))
        assertEquals("Tá sé cúig nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 5)))
        assertEquals("Tá sé deich nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 10)))
        assertEquals("Tá sé aon déag nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 11)))
        assertEquals("Tá sé ceithre déag nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 14)))
        assertEquals("Tá sé sé déag nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 16)))
        assertEquals("Tá sé naoi déag nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 19)))
        assertEquals("Tá sé fiche nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 20)))
        assertEquals("Tá sé fiche is aon nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 21)))
        assertEquals("Tá sé fiche is cúig nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 25)))
        assertEquals("Tá sé fiche is naoi nóiméad tar éis a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 29)))
    }

    @Test fun testMinutesTo() {
        assertEquals("Tá sé fiche is naoi nóiméad chun a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 31)))
        assertEquals("Tá sé fiche is cúig nóiméad chun a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 35)))
        assertEquals("Tá sé fiche nóiméad chun a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 40)))
        assertEquals("Tá sé deich nóiméad chun a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 50)))
        assertEquals("Tá sé aon nóiméad chun a dó", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(1, 59)))
        assertEquals("Tá sé cúig nóiméad chun a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(23, 55)))
        assertEquals("Tá sé dhá nóiméad chun a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(11, 58)))
    }

    @Test fun testEdgeCases() {
        assertEquals("Tá sé aon nóiméad tar éis a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(12, 1)))
        assertEquals("Tá sé aon nóiméad chun a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(12, 59)))
        assertEquals("Tá sé aon nóiméad tar éis a dó dhéag", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(0, 1)))
        assertEquals("Tá sé aon nóiméad chun a haon", GaeilgeTimeFormatter.getIrishTimePhrase(createCalendar(0, 59)))
    }
}