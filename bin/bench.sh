#!/usr/bin/env bash
set -e
declare -r ROOT_DIR=${GITHUB_WORKSPACE:-$(git rev-parse --show-toplevel)}
declare -r TIPC=${ROOT_DIR}/build/src/tipc
declare -r RTLIB=${ROOT_DIR}/rtlib

if [ "${1}" == "help" ]; then
  echo ""
  echo "Usage: $0 -optTag file.tip"
  echo -e "\t-optTag the optimization tag you want to test"
  exit 1
fi

# unoptimized
exec="$(dirname "${2}")/$(basename "${2}" .tip)"
echo ""
echo "without ${1}"
${TIPC} "${2}"
${TIPCLANG} -w "${2}".bc "${RTLIB}"/tip_rtlib.bc -o "${exec}"
time "${exec}" 20000
# optimized
echo ""
echo  "with ${1}"
${TIPC} "$1" "${2}"
${TIPCLANG} -w "${2}".bc "${RTLIB}"/tip_rtlib.bc -o "${exec}"
time "${exec}" 20000
# cleanup
rm "$(dirname "${2}")/${2}.bc"
rm "${exec}"
