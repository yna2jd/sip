declare -r ROOT_DIR=${TIPDIR:-$(git rev-parse --show-toplevel)}
cd ${ROOT_DIR}/build/
../bin/cleancov.sh
make -s -j6 semantic > ${ROOT_DIR}/build/.makesemantic
${ROOT_DIR}/build/test/unit/semantic/semantic_unit_tests