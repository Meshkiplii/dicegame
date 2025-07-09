# DiceRoller App

DiceRoller is a simple Android application built with Jetpack Compose that allows users to roll a virtual six-sided die and view a history of their rolls.

## Features

*   **Roll a Die:** Tap a button to simulate rolling a six-sided die.
*   **Visual Feedback:** The die image animates with a rotation effect on each roll.
*   **Current Roll Display:** The result of the most recent roll is displayed numerically.
*   **Roll History:** View a list of all previous dice rolls.
*   **Clear History:** Option to clear the entire roll history.
*   **Modern UI:** Built entirely with Jetpack Compose for a declarative and modern user interface.
*   **Navigation:** Uses Jetpack Navigation Compose for navigating between the game screen and the history screen.
*   **State Management:** Utilizes `ViewModel` and `StateFlow` for robust state management, following modern Android architecture patterns.

## Tech Stack

*   **Kotlin:** Primary programming language.
*   **Jetpack Compose:** For building the native UI.
*   **Material 3:** For Material Design components and styling.
*   **Jetpack Navigation Compose:** For in-app navigation.
*   **ViewModel:** To store and manage UI-related data in a lifecycle-conscious way.
*   **StateFlow & CollectAsStateWithLifecycle:** For reactive state management.
*   **Coroutines:** For asynchronous operations (implicitly used by StateFlow).

## Architecture

The app follows a basic MVVM (Model-View-ViewModel) like architecture:

*   **View (`Composable` functions like `GameScreen`, `HistoryScreen`):** Observes data from the ViewModel and renders the UI. User interactions are forwarded to the ViewModel.
*   **ViewModel (`GameViewModel`):** Holds and processes the application's data. It exposes UI state via `StateFlow` and handles business logic (like rolling the dice, managing history).
*   **Model (Implicit):** The data classes or primitive types representing the dice value and roll history (e.g., `RollHistoryItem`).

## How to Build

1.  Clone the repository:
    