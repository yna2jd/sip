#!/usr/bin/env bash
set -e
declare -r ROOT_DIR=${TIPDIR:-$(git rev-parse --show-toplevel)}
${ROOT_DIR}/bin/buildall.sh
echo running tests
${ROOT_DIR}/bin/runtests.sh