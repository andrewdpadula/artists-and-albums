//delete an album
const albumsList = document.querySelector('.albumList');
albumsList.addEventListener('click', removeAlbum);
function removeAlbum(event){
    if(event.target.classList.contains('deleteAlbum')){
        const deleteButton = event.target
        const albumContainer = deleteButton.parentElement
        const hrefArray = albumContainer.querySelector('a').getAttribute('href').split("/")
        const artistName = hrefArray[2]
        const albumName = hrefArray[4]

        const xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingAlbums = JSON.parse(response.currentTarget.response);    
                let list = ''
                remainingAlbums.forEach(function(album){
                    list += `
                        <li>
                            <a href="artist/${artist.name}/album/${album.albumName}">${album.albumName}</a>
                            <button class="deleteAlbum">Delete</button>
                            <button class="editAlbum">Edit</button>
                        </li>
                    `
                })
                albumsList.innerHTML = list
            }
        }
        xhr.open("DELETE", `/api/artist/${artistName}/album?albumName=${albumName}`, true)
        xhr.send()
    }
}