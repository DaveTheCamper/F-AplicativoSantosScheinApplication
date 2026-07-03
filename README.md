# Complexo Esportivo Santos e Schein

Aplicativo Android em Java para agendamento de horarios em campos de futebol do Complexo Esportivo Santos e Schein. O projeto esta preparado para rodar sem backend no modo mock/dev e para usar chamadas HTTP reais no modo remoto/prod.

## Tecnologias

- Java 21
- Gradle e Android Gradle Plugin
- AndroidX, Fragment, RecyclerView, ViewModel e LiveData
- Material Components
- Retrofit, OkHttp e Gson
- Lombok
- JUnit, Mockito e AndroidX Arch Core Testing

## Arquitetura

O app segue Clean Architecture com separacao entre apresentacao, dominio, dados e infraestrutura compartilhada.

- `core`: configuracao, rede, sessao, erros e utilitarios.
- `domain`: modelos, contratos de repositorio e casos de uso. Nao depende de Android, Retrofit, DTOs ou UI.
- `data`: APIs Retrofit, DTOs, mappers, repositorios remotos e repositorios mockados em memoria.
- `presentation`: Fragments, ViewModels, adapters, estado de tela e navegacao.

Os use cases dependem apenas das interfaces em `domain.repository`. Os ViewModels chamam use cases e expoem `LiveData<UiState<T>>`. Os repositorios remotos convertem DTOs para modelos de dominio e usam um mapeamento centralizado de erros amigaveis.

## Estrutura

```text
com.santosschein.app
|-- core
|   |-- config
|   |-- error
|   |-- network
|   |-- session
|   `-- util
|-- data
|   |-- mock
|   |-- remote
|   |   |-- api
|   |   |-- dto
|   |   `-- mapper
|   `-- repository
|-- domain
|   |-- model
|   |-- repository
|   `-- usecase
`-- presentation
    |-- auth
    |-- home
    |-- navigation
    |-- profile
    `-- reservation
```

## Como abrir no Android Studio

1. Abra a pasta `C:\Users\theda\AndroidStudioProjects\ComplexoSantosSchein`.
2. Aguarde a sincronizacao do Gradle.
3. Abra `Build Variants`.
4. Selecione `mockDebug` para rodar sem backend ou `prodDebug` para chamadas HTTP locais.
5. Execute o app em um emulador ou dispositivo.

Se o Android Studio mostrar a mensagem `Can't find module entity`, feche e reabra o projeto depois da sincronizacao Gradle. O modulo esperado e `Complexo_Santos_e_Schein.app`.

## Modo mock/dev

Use o Build Variant `mockDebug`. Nesse modo, os repositorios usam dados em memoria e nao dependem de servidor real.

Credenciais mock:

```text
E-mail: usuario@teste.com
Senha: 123456
```

Fluxos cobertos no mock: login, cadastro, home, nova reserva, reservas futuras, reservas passadas, cancelamento, perfil e logout.

## Modo remoto/prod

Use o Build Variant `prodDebug` ou `prodRelease`. Nesse modo, os repositorios usam Retrofit e OkHttp para chamar o backend configurado.

A URL padrao e:

```text
http://10.0.2.2:8080/
```

No emulador Android, `10.0.2.2` aponta para o `localhost` da maquina host. Em dispositivo fisico, altere a URL para o IP da maquina que executa o backend.

## Configurar URL base

A URL base fica em [app/build.gradle](C:/Users/theda/AndroidStudioProjects/ComplexoSantosSchein/app/build.gradle):

```gradle
buildConfigField "String", "API_BASE_URL", "\"http://10.0.2.2:8080/\""
```

Altere esse valor no flavor `prod` quando o backend real existir. O flavor `mock` mantem a mesma URL apenas para preservar a configuracao, mas nao realiza chamadas HTTP.

## Testes

Rodar testes unitarios:

```powershell
.\gradlew.bat test --console=plain
```

Rodar build completo com lint, testes e assemble:

```powershell
.\gradlew.bat clean build --console=plain
```

Gerar APK de desenvolvimento:

```powershell
.\gradlew.bat assembleMockDebug --console=plain
```

## Endpoints esperados

- `POST /api/v1/auth/login`
- `POST /api/v1/auth/register`
- `GET /api/v1/users/me/reservations/next`
- `GET /api/v1/reservations/available-days?year=2026&month=7`
- `GET /api/v1/reservations/available-slots?date=2026-07-10`
- `POST /api/v1/reservations`
- `GET /api/v1/users/me/reservations?status=upcoming`
- `GET /api/v1/users/me/reservations?status=past`
- `DELETE /api/v1/users/me/reservations/{reservationId}`
- `GET /api/v1/users/me`

## Observacoes importantes

- Este projeto nao implementa backend.
- Este projeto nao usa Room, SQLite, Realm ou qualquer banco local para regras de negocio.
- O modo mock usa dados simulados em memoria.
- A sessao usa `SharedPreferences` apenas para token JWT e dados minimos de sessao.
- O modo remoto foi preparado para HTTP com backend em `localhost`.

## Troubleshooting

O ambiente local pode ter inspecao HTTPS por antivirus/proxy. Para evitar falhas como `PKIX path building failed` ou `certificate_unknown`, o projeto aponta o Gradle para um truststore local em `.gradle/codex-truststore/cacerts`.

Se os certificados locais forem regenerados, recrie esse truststore antes de sincronizar ou rodar os testes novamente.
