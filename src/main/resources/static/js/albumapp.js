// Add an album comment
const submitButton = document.querySelector(".submitComment");
const albumName = document.querySelector("[name='albumName']");
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
    xhr.open("POST", `/api/album/${albumName.value}?userName=${userNameApi.value}&comment=${commentApi.value}`, true)
    xhr.send()
})


//delete a song
const songList = document.querySelector('.songList');
songList.addEventListener('click', removeSong);
function removeSong(event){
    if(event.target.classList.contains('deleteSong')){
        const deleteButton = event.target
        const songContainer = deleteButton.parentElement
        const hrefArray = songContainer.querySelector('a').getAttribute('href').split("/")
        const albumName = hrefArray[hrefArray.length - 3]
        const songId = hrefArray[hrefArray.length - 1]

        const xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingSongs = JSON.parse(response.currentTarget.response);    
                let list = ''
                remainingSongs.forEach(function(song){
                    list += `
                        <li>
                            <a href="album/${albumName}/song/${song.id}">${song.songName}</a>
                            <button class="deleteSong">Delete</button>
                            <button class="editSong">Edit</button>
                        </li>
                    `
                })
                songList.innerHTML = list
            }
        }
        xhr.open("DELETE", `/api/album/${albumName}/song?id=${songId}`, true)
        xhr.send()
    }
}