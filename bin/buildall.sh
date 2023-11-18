declare -r ROOT_DIR=${TIPDIR:-$(git rev-parse --show-toplevel)}
cd ${ROOT_DIR}/build/
../bin/cleancov.sh
cmake .. >  ${ROOT_DIR}/build/.buildall
echo cmake done
make -j6 all > ${ROOT_DIR}/build/.buildall
echo completed
