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

<img width="720" height="1280" alt="Screenshot_20260708-235915" src="https://github.com/user-attachments/assets/100c0559-43f8-42f6-826e-367dc201bd98" />
<img width="720" height="1280" alt="Screenshot_20260708-235936" src="https://github.com/user-attachments/assets/08a15ed6-0719-4a3c-87b2-673fdde999b6" />
<img width="720" height="1280" alt="Screenshot_20260709-000018" src="https://github.com/user-attachments/assets/5caaa654-ffc1-4c73-be82-2f98ec57ceb3" />
<img width="720" height="1280" alt="Screenshot_20260709-000025" src="https://github.com/user-attachments/assets/a25af36d-f496-4f7a-ad9e-95ab8b30b557" />
<img width="720" height="1280" alt="Screenshot_20260709-000055" src="https://github.com/user-attachments/assets/406e46d3-749d-4937-a241-6ad50602d66d" />
<img width="720" height="1280" alt="Screenshot_20260709-000102" src="https://github.com/user-attachments/assets/2a8f882f-b598-4d70-9c27-0222e328c456" />
<img width="720" height="1280" alt="Screenshot_20260709-000115" src="https://github.com/user-attachments/assets/31dd3be4-e5e4-41b0-9730-eb55a94afe91" />







