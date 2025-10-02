# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

Project overview
- Stack: Java 22, Gradle (with wrapper), libGDX. Generated via gdx-liftoff.
- Modules:
  - core: shared game/application logic and resources processing hook.
  - lwjgl3: desktop launcher (LWJGL3 backend) and packaging logic.
- Entry point (desktop): com.github.pozzrar.strategygame.lwjgl3.Lwjgl3Launcher
- Assets: assets/ directory is included on the runtime classpath for the desktop app. A Gradle task generates assets.txt from assets/ and is wired into resource processing.

Development commands (Windows PowerShell)
- List tasks
  - .\gradlew.bat tasks --all
- Build all projects
  - .\gradlew.bat build
- Clean build outputs
  - .\gradlew.bat clean
- Run desktop app (LWJGL3)
  - .\gradlew.bat lwjgl3:run
- Create runnable desktop JAR (cross-platform natives)
  - .\gradlew.bat lwjgl3:jar
  - Output: lwjgl3/build/libs/StrategyGameSimulation-<version>.jar
- Create platform-specific desktop JARs (smaller size)
  - macOS-only
    - .\gradlew.bat lwjgl3:jarMac
  - Linux-only
    - .\gradlew.bat lwjgl3:jarLinux
  - Windows-only
    - .\gradlew.bat lwjgl3:jarWin
- Run unit tests (if present)
  - All tests
    - .\gradlew.bat test
  - Single test class or method (examples)
    - By class: .\gradlew.bat test --tests "com.example.MyTest"
    - By method: .\gradlew.bat test --tests "com.example.MyTest.myMethod"

Notes about Gradle configuration
- Java toolchain and IDE: The project configures IDEA output dirs and sets Java 22 compatibility in modules. If using a different local JDK, prefer Gradle’s toolchain or run via the wrapper.
- Assets list generation: A generateAssetList task writes assets/assets.txt from the assets/ directory and is set as a dependency of processResources in all subprojects. This ensures packaged resources reflect assets/ contents.
- Desktop run working directory: lwjgl3:run sets workingDir to assets/, so relative paths for assets are resolved as expected during development.
- Packaging: The desktop module configures a fat JAR with manifest Main-Class set to the launcher and Enable-Native-Access for newer JDKs. Platform-specific JAR tasks exclude non-target natives to reduce size.
- Optional native image: If the Gradle property enableGraalNative == 'true' is provided and the plugin is applied, lwjgl3/nativeimage.gradle configures org.graalvm.buildtools.native, including resource configuration generation from assets/.

High-level architecture
- core (game logic and shared code)
  - Depends on libGDX core (gdx), gdx-freetype, gdx-ai, and Ashley (entity-component system). This module is intended to hold gameplay systems, ECS components and systems, AI logic, and shared screens.
  - When enableGraalNative is true, it also brings in SVM Helper annotations for Graal Native compatibility.
- lwjgl3 (desktop launcher and distribution)
  - Depends on core and the LWJGL3 backend plus native classifiers for desktop.
  - Declares main class com.github.pozzrar.strategygame.lwjgl3.Lwjgl3Launcher which initializes the Application, config, and sets the initial Screen from core.
  - Configures packaging tasks (jar, jarMac, jarLinux, jarWin). Also includes optional Construo configuration for building platform distributions (targets defined; consult Gradle tasks for available packaging commands in your environment).

Conventions and paths
- Source layout follows standard Gradle conventions (src/main/java or src/main/kotlin in each module). If you add sources, place them under the corresponding module’s src tree.
- Assets live in assets/. The desktop launcher includes this directory on the runtime classpath and sets it as the working directory when running.

Incorporated README highlights
- The project was generated with gdx-liftoff and includes simple launchers and a Game subclass that sets the first Screen.
- Useful tasks: build, test, lwjgl3:run, lwjgl3:jar (see commands above). Prefixed tasks can be scoped to a specific module (e.g., core:clean).
