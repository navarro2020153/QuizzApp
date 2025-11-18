QuizzApp (v2)

Aplicación de preguntas tipo quiz, desarrollada en Kotlin para Android.
Esta versión (v2) implementa la segunda fase del proyecto: app dinámica, funcional, con navegación, puntaje y mensajes interactivos.

🚀 Características principales
✔ Preguntas dinámicas

Las preguntas ya no son estáticas:

Se almacenan en una lista (List<Question>).

Se navega entre ellas usando un índice (currentIndex).

✔ Botones Verdadero / Falso

Cada botón evalúa la respuesta e informa al usuario mediante Toast.

✔ Control de puntaje

Cada acierto suma 1 punto.
El puntaje se muestra en pantalla y también al finalizar el quiz.

✔ Botón Siguiente / Finalizar / Reiniciar

Dependiendo del avance:

“Siguiente” → Cambia a la siguiente pregunta

“Finalizar” → Muestra resultado final

“Reiniciar” → Vuelve a empezar el quiz

✔ Bloqueo de botones

Después de responder una pregunta, los botones se desactivan para evitar múltiples intentos.

✔ Barrita de progreso

Muestra:
Pregunta X de N

✔ Diseño limpio y centrado

Interfaz construida con:

LinearLayout vertical

LinearLayout horizontal

Márgenes, padding y tamaños de texto adecuados

🛠 Tecnologías utilizadas

Kotlin

Android Studio

Layouts XML

Toast API

Activities

Git + GitHub



Estructura de archivos relevante
QuizzApp(v2)/
 └── app/src/main/java/com/example/quizzapp/
       └── MainActivity.kt
 └── app/src/main/res/layout/
       └── activity_main.xml
 └── app/src/main/res/values/
       └── strings.xml


       Autor
Carlos Navarro
Estudiante de TI | Desarrollador Android Jr.
2025
