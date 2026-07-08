# QuoteApp

An Android application built to demonstrate clean architecture patterns, unidirectional data flow, and modern UI implementation using Jetpack Compose.

## 📸 Screenshots
<!-- Chobi gulo ekhane drag and drop korun -->


## 🧠 Architectural & Engineering Choices

* **Separation of Concerns:** Implemented using the **MVVM (Model-View-ViewModel)** pattern to strictly decouple the UI layer from the data management logic.
* **Declarative UI:** Developed entirely with **Jetpack Compose**, leveraging state hoisting and composition lifecycles to maintain a predictable UI state.
* **Data Layer Integration:** Handles remote data mapping via custom JSON structures (integrated with JSONBin), ensuring robust parsing before exposing data to the domain layer.
* **Theme Management:** Features dynamic dark/light mode configurations that respond natively to system changes.

## 🛠️ Technical Challenges & Fixes

This project served as a practical ground for debugging and resolving real-world mobile development bottlenecks:

* **Payload Mapping & Crash Resolution:** Diagnosed and refactored underlying data models to address critical runtime crashes caused by mismatched remote API payloads during data fetching.
* **Layout Optimization:** Resolved UI rendering constraints by properly configuring scroll states and view modifiers, preventing potential interface clipping and ensuring a smooth user experience.

## 💻 Tech Stack
* **Language:** Kotlin
* **UI Toolkit:** Jetpack Compose
* **Architecture:** MVVM (Model-View-ViewModel)
* **Backend/API:** JSONBin
