#!/usr/bin/env bash
# Regenerate the generated client from the vendored openapi.json.
# Hand-written files (src/main/kotlin/com/currencycore/sdk/Client.kt, README)
# are protected by .openapi-generator-ignore.
set -euo pipefail
cd "$(dirname "$0")/.."
npx -y @openapitools/openapi-generator-cli generate \
  -i openapi.json -g kotlin -o . \
  --additional-properties=groupId=com.currencycore,artifactId=currencycore-sdk,packageName=com.currencycore.sdk
