#!/bin/bash
declare -r ROOT_DIR=${TRAVIS_BUILD_DIR:-$(git rev-parse --show-toplevel)}
declare -r TIPC=${ROOT_DIR}/build/src/tipc
declare -r RTLIB=${ROOT_DIR}/rtlib
declare -r SCRATCH_DIR=$(mktemp -d)

if [ -z "${TIPCLANG}" ]; then
  echo error: TIPCLANG env var must be set
  exit 1
fi

curdir="$(basename `pwd`)"
if [ "${curdir}" != "system" ]; then
  echo "Test runner must be executed in .../tipc/test/system"
  exit 1
fi

numtests=0
numfailures=0

initialize_test() {
  echo -n "."
  rm -f ${SCRATCH_DIR}/*
  ((numtests++))
}

# Self contained test cases
for i in whitelistedtests/*.tip
do
  base="$(basename $i .tip)"

#  # test optimized program
#  initialize_test
#  ${TIPC} $i
#  ${TIPCLANG} -w $i.bc ${RTLIB}/tip_rtlib.bc -o $base
#
#  ./${base} &>/dev/null
#  exit_code=${?}
#  if [ ${exit_code} -ne 0 ]; then
#    echo -n "Test failure for : "
#    echo $i
#    ./${base}
#    ((numfailures++))
#  else
#    rm ${base}
#  fi
#  rm $i.bc

  # test unoptimized program
  initialize_test
  :> ${ROOT_DIR}${1}/.log
  ${TIPC} -do --log=${ROOT_DIR}/${1}.log --pt --verbose=2 $i
  ${TIPCLANG} -w $i.bc ${RTLIB}/tip_rtlib.bc -o $base

  ./${base} &>/dev/null
  exit_code=${?}
  if [ ${exit_code} -ne 0 ]; then
    echo -n "Test failure for : "
    echo $i
    ./${base}
    ((numfailures++))
  else
    rm ${base}
  fi
  rm $i.bc

done

# Print out the test results
if [ ${numfailures} -eq "0" ]; then
  echo -n " all " 
  echo -n ${numtests}
  echo " tests passed"
else
  echo -n " " 
  echo -n ${numfailures}/${numtests}
  echo " tests failed"
fi

rm -r ${SCRATCH_DIR}
