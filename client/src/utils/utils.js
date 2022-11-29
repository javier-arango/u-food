export const verifyPassword = function (password1, password2) {
    //check that both passwords match
    if (password1 !== password2)
    {
        return false;
    }

    //check that password is more than 8 characters
    if (password1.length < 8)
    {
        return false;
    }

    //check if one special character using regex
    const pattern = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    let result = pattern.test(password1);

    return result;
}

//expecting userLoc and restLoc to be objects with lat (latitude) and long (longitude)
export const distanceToRest = function(userLoc, restLoc) {

    const radEarth = 3963; //earth radius in miles
    const p = 0.017453292519943295; //pi/180  as const for easier calculations

    let val1 = 0.5 - Math.cos((restLoc.lat - userLoc.lat) * p) / 2
        + Math.cos(userLoc.lat * p) * Math.cos(restLoc.lat * p) * (1 - Math.cos((restLoc.long - userLoc.long) * p)) / 2;

    let distance = 2 * radEarth * Math.asin(Math.sqrt(val1));

    return distance.toFixed(2) //returns total distance between user and restaurant in miles to 2 decimals
}