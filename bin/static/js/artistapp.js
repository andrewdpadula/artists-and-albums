//add an album
const submitButton = document.querySelector(".submitAlbum");
const albumList = document.querySelector(".albumList");
const albumNameApi = document.querySelector("[name='albumNameApi']");
const releaseDateApi = document.querySelector("[name='releaseDateApi']");
const genreApi = document.querySelector("[name='genreApi']");
const artistName = document.querySelector("[name='artistName']");
submitButton.addEventListener("click", function submitAlbum(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            console.log(response.currentTarget.response)
            const albums = JSON.parse(response.currentTarget.response)
            let list = '';
            albums.forEach(album => {
                list += `
                    <li>
                        <a href="/artists/${artistName.value}/album/${album.albumName}">
                            <span>${album.albumName}</span>
                        </a>
                        <button class="deleteAlbum">Delete</button>
                        <button class="editAlbum">Edit</button>
                    </li>
                `
            })
            albumList.innerHTML = list
        }
    })
    xhr.open("POST", `/api/artists/${artistName.value}/album/?albumName=${albumNameApi.value}&releaseDate=${releaseDateApi.value}&genre=${genreApi.value}`, true)
    xhr.send()
})


//delete an album
albumList.addEventListener('click', removeAlbum);
function removeAlbum(event){
    if(event.target.classList.contains('deleteAlbum')){
        const deleteButton = event.target
        const albumContainer = deleteButton.parentElement
        const hrefArray = albumContainer.querySelector('a').getAttribute('href').split("/")
        const artistName = hrefArray[hrefArray.length - 3]
        const albumName = hrefArray[hrefArray.length - 1]

        const xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingAlbums = JSON.parse(response.currentTarget.response);    
                let list = ''
                remainingAlbums.forEach(function(album){
                    list += `
                        <li>
                            <a href="artists/${artistName}/album/${album.albumName}">${album.albumName}</a>
                            <button class="deleteAlbum">Delete</button>
                            <button class="editAlbum">Edit</button>
                        </li>
                    `
                })
                albumList.innerHTML = list
            }
        }
        xhr.open("DELETE", `/api/artists/${artistName}/album?albumName=${albumName}`, true)
        xhr.send()
    }
}