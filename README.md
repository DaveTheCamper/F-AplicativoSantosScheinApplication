# Complexo Santos e Schein

Aplicativo Android em Java para agendamento de horarios em campos de futebol do Complexo Esportivo Santos e Schein.

## Arquitetura

O projeto foi iniciado com Clean Architecture em camadas:

- `core`: configuracao, rede, sessao, erros e utilitarios compartilhados.
- `data`: fontes remotas, DTOs, mappers, mocks e implementacoes de repositorio.
- `domain`: modelos, contratos de repositorio e casos de uso.
- `presentation`: fragments, ViewModels, estado de tela e navegacao.

O app nao usa banco de dados local para regras de negocio. A sessao usa `SharedPreferences` apenas para token JWT.

## Ambientes

Existem dois product flavors:

- `mock`: usa dados simulados locais.
- `prod`: prepara chamadas HTTP reais para `http://10.0.2.2:8080/`, endereco usado pelo emulador Android para acessar o localhost da maquina host.

A troca e feita pelo Build Variant do Android Studio.

## Como rodar no Android Studio

1. Abra este diretorio no Android Studio: `C:\Users\theda\AndroidStudioProjects\ComplexoSantosSchein`.
2. Aguarde a sincronizacao Gradle.
3. Abra `Build Variants`.
4. Selecione `mockDebug` para desenvolvimento sem backend, ou `prodDebug` para chamadas HTTP locais.
5. Execute o app em um emulador ou dispositivo.

## Testes

Pelo terminal:

```powershell
.\gradlew.bat test
```

Para montar o APK:

```powershell
.\gradlew.bat assembleMockDebug
```

## Troubleshooting

O ambiente local usa o AVG Web/Mail Shield para inspecionar HTTPS. Para evitar falhas `PKIX path building failed` ou `certificate_unknown`, o projeto aponta o Gradle para um truststore local em `.gradle/codex-truststore/cacerts`, gerado a partir do `cacerts` do JBR do Android Studio com os certificados apresentados por `services.gradle.org`, `dl.google.com` e Maven Central.

Se o AVG regenerar seus certificados, recrie esse truststore antes de sincronizar ou rodar os testes novamente.
