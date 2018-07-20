const submitButton = document.querySelector(".submitComment");
const albumId = document.querySelector("[name='albumId']");
const commentList = document.querySelector(".commentList");
const userNameApi = document.querySelector("[name='userNameApi']");
const commentApi = document.querySelector("[name='commentApi']");
submitButton.addEventListener("click", function submitComment(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function submit(response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const comments = JSON.parse(response.currentTarget.response)
            let list = '';
            comments.forEach(comment => {
                list += `
                    <li>
                        <span>${comment.userName}: ${comment.comment}</span>
                    </li>
                `
            })
            commentList.innerHTML = list
        }
    })
    xhr.open("POST", `/api/album/${albumId.value}?userName=${userNameApi.value}&comment=${commentApi.value}`, true)
    xhr.send()
})