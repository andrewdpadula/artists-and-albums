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