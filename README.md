# Nosso RPG

Jogo clicker de RPG para Android (Kotlin, Jetpack Compose, Room, kotlinx.serialization).
Projeto recriado a partir de `docs/ESPECIFICACAO_RPG_original.txt`.

## Como buildar
1. Instale o Android Studio (ou apenas o Android SDK + JDK 17).
2. Edite `local.properties` e aponte `sdk.dir` para o seu Android SDK.
3. Na pasta do projeto:
   - `./gradlew assembleDebug --no-daemon`
   - `./gradlew installDebug --no-daemon` (ou `adb install -r app/build/outputs/apk/debug/app-debug.apk`)

No Windows use `gradlew.bat`.

## Estrutura
```
nosso-rpg/
├── build.gradle.kts / settings.gradle.kts / gradle.properties
├── gradlew, gradlew.bat, gradle/wrapper/
├── local.properties        (ajustar sdk.dir)
├── TOMORROW.md             (plano / roadmap)
├── docs/                   (especificacao original)
└── app/
    ├── build.gradle.kts
    └── src/main/
        ├── AndroidManifest.xml
        ├── assets/         enemies.json, areas.json, upgrades.json
        ├── java/com/rpgclicker/
        │   ├── MainActivity.kt, RpgClickerApplication.kt
        │   ├── data/local/        Room (DAO, entidades, mappers)
        │   ├── data/repository/   GameRepository (+ seed dos JSON)
        │   ├── domain/model/      Hero, Enemy, GameState, Upgrades
        │   ├── domain/usecase/    GameEngine (regras do jogo)
        │   ├── presentation/      viewmodel, screen, util
        │   └── ui/theme/          Theme.kt
        └── res/            values, drawable (arte provisoria), mipmap
```

## Ajustes em relacao a especificacao original
A especificacao tinha trechos que nao compilariam; foram corrigidos/completados:
- `build.gradle.kts` da raiz continha conteudo de settings; agora declara os plugins.
- Plugin `kotlin-kapt`, BOM do Compose e `kotlinx-datetime` adicionados; removida a dependencia invalida `room-gradle-plugin`.
- Modelos que faltavam: `Area`, `Prestige`, `GameSettings`, `GameStatistics`; `Hero` ganhou `critChance`, `critDamageMultiplier` e `goldMultiplier`.
- `GameEngine`: `kotlin.math.pow` -> `Math.pow`, auto-batalha com escopo proprio, Mutex contra corrida, XP/nivel, avanco de area e multiplicador de ouro.
- `GameDao`: Flow nulo-seguro e `observeAllUpgrades`.
- Compose: `@file:OptIn` no topo, imports invalidos removidos, `EnemyCard` agora e clicavel, `Theme.kt` usa `Color(...)`.
- Adicionados: seed dos JSON, `themes.xml`, `strings.xml`, `colors.xml`, icones do launcher e toda a arte provisoria.

> Observacao: o projeto nao foi compilado no ambiente em que foi gerado (sem Android SDK). Se o Gradle apontar algum erro, me envie a mensagem.
