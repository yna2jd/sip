declare -r ROOT_DIR=${TIPDIR:-$(git rev-parse --show-toplevel)}
cd ${ROOT_DIR}/build/
make -s -j7 frontend_unit_tests > makefrontend.log
${ROOT_DIR}/build/test/unit/frontend/frontend_unit_tests
