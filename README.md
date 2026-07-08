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

* <table align="center">
  <tr>
    <td><img src="https://github.com/user-attachments/assets/100c0559-43f8-42f6-826e-367dc201bd98" width="240" alt="Home"/></td>
    <td><img src="https://github.com/user-attachments/assets/d34d8d08-95e5-4bb1-9a3b-ea4c2fa04560" width="240" alt="Categories"/></td>
    <td><img src="https://github.com/user-attachments/assets/a25af36d-f496-4f7a-ad9e-95ab8b30b557" width="240" alt="Favorites"/></td>
  </tr>
  <tr align="center">
    <td><b>Home Screen</b></td>
    <td><b>Categories</b></td>
    <td><b>Favorites</b></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/406e46d3-749d-4937-a241-6ad50602d66d" width="240" alt="Detail"/></td>
    <td><img src="https://github.com/user-attachments/assets/08a15ed6-0719-4a3c-87b2-673fdde999b6" width="240" alt="Dark Mode"/></td>
  </tr>
  <tr align="center">
    <td><b>Quote Detail</b></td>
    <td><b>Dark Mode</b></td>
  </tr>
</table>








