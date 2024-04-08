
function loginOrRegister(student,studentAction){
    console.log(student)
    fetch(
        `http://localhost:8080/student/${studentAction}`,{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(student)
        }).then(response=>response.json()).then(row=>console.log(row))
}
export {loginOrRegister}