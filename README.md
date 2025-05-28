# GaeilgeTimeFormatter-Android

A Kotlin library for converting `Calendar` objects into natural, idiomatic Irish (Gaeilge) time phrases.

## Installation

### Gradle (Recommended)

Add the `GaeilgeTimeFormatter-Android` library to your project by including it as a module or linking to the source.

If published on Maven (future step), you would add:

```gradle
implementation 'com.yourgroup:gaeilgetimeformatter-android:1.0.0'
```

## Usage

Import `GaeilgeTimeFormatter` into your Kotlin file:

```kotlin
import com.example.gaeilgetimeformatter.GaeilgeTimeFormatter
import java.util.Calendar

// Get current time in Irish
val currentTimeInIrish = GaeilgeTimeFormatter.getIrishTimePhrase()
println(currentTimeInIrish)

// Get specific time in Irish
val calendar = Calendar.getInstance().apply {
    set(2024, Calendar.MARCH, 15, 14, 45) // March 15, 2024, 14:45 (2:45 PM)
}

val specificTimeInIrish = GaeilgeTimeFormatter.getIrishTimePhrase(calendar)
println(specificTimeInIrish)

// Output: "Tá sé ceathrú chun a trí" (It is quarter to three)

// Example for 1:05 AM
val calendar1_05 = Calendar.getInstance().apply {
    set(2024, Calendar.MARCH, 15, 1, 5)
}
println("01:05 -> " + GaeilgeTimeFormatter.getIrishTimePhrase(calendar1_05))

// Output: "01:05 -> Tá sé cúig nóiméad tar éis a haon"
```

## Time Format Patterns

The library follows traditional Irish time-telling patterns:

- **On the hour:** `Tá sé a [hour] a chlog`  
  Example: "Tá sé a haon a chlog" (It's one o'clock)
- **Past the hour (1–29 minutes):** `Tá sé [minutes] tar éis a [hour]`  
  Example: "Tá sé cúig nóiméad tar éis a dó" (It's five past two)
- **Half past:** `Tá sé leathuair tar éis a [hour]`  
  Example: "Tá sé leathuair tar éis a trí" (It's half past three)
- **To the hour (31–59 minutes):** `Tá sé [minutes] chun a [next hour]`  
  Example: "Tá sé deich nóiméad chun a ceathair" (It's ten to four)
- **Quarter past:** `Tá sé ceathrú tar éis a [hour]`  
  Example: "Tá sé ceathrú tar éis a dó dhéag" (It's quarter past twelve)
- **Quarter to:** `Tá sé ceathrú chun a trí`  
  Example: "Tá sé ceathrú chun a trí" (It's quarter to three)

## Features

✅ Converts standard `Calendar` objects to idiomatic Irish time phrases  
✅ Handles minutes (1–29 ‘tar éis’ and 1–29 ‘chun’) and special cases like quarter past/to and half past  
✅ Uses traditional Irish number forms for hours and minutes where applicable  
✅ Returns grammatically correct Irish phrases  
✅ Zero external dependencies (pure Kotlin, no extra libraries)

## Contributing

Contributions are very welcome! If you have suggestions for improvements, find a bug, or want to add more features, please get in touch or open a pull request.

## License

This project is licensed under the MIT License — see the `LICENSE` file for details.

## Support

If you found this library helpful, you can:

- ⭐ Star the project on GitHub  
- 🐛 Report any issues you find  
- ☕ [Buy me a coffee](https://www.buymeacoffee.com/peterelst)
