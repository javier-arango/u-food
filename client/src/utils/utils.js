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