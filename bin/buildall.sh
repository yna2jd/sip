declare -r ROOT_DIR=${TIPDIR:-$(git rev-parse --show-toplevel)}
cd ${ROOT_DIR}/build/
../bin/cleancov.sh
cmake .. >  ${ROOT_DIR}/build/.buildall
echo cmake done
make -s -j7 all > ${ROOT_DIR}/build/.buildall
${ROOT_DIR}/bin/runtests.sh
