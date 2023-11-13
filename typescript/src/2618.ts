function checkIfInstanceOf(obj: any, classFunction: any): boolean {
  if (
    obj === null ||
    obj === undefined ||
    classFunction === null ||
    classFunction === undefined
  ) {
    return false;
  }

  let currentProto = Object.getPrototypeOf(obj);

  while (currentProto !== null) {
    if (currentProto == classFunction.prototype) {
      return true;
    }
    currentProto = Object.getPrototypeOf(currentProto);
  }

  return false;
}

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */

export { checkIfInstanceOf };
