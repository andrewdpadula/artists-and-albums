//add an artist
const submitButton = document.querySelector(".submitArtist");
const artistList = document.querySelector(".artistList");
const artistNameApi = document.querySelector("[name='artistNameApi']");
const recordLabelApi = document.querySelector("[name='recordLabelApi']");
submitButton.addEventListener("click", function submitArtist(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            console.log(response.currentTarget.response)
            const artists = JSON.parse(response.currentTarget.response)
            let list = '';
            artists.forEach(artist => {
                list += `
                    <li>
                        <a href="/artists/${artist.name}">
                            <span>${artist.name}</span>
                        </a>
                    </li>
                `
            })
            artistList.innerHTML = list
        }
    })
    xhr.open("POST", `/api/artists/?name=${artistNameApi.value}&recordLabel=${recordLabelApi.value}`, true)
    xhr.send()
})

//delete an artist
artistList.addEventListener('click', removeArtist);
function removeArtist(event){
    if(event.target.classList.contains('deleteArtist')){
        const deleteButton = event.target
        const artistContainer = deleteButton.parentElement
        const hrefArray = artistContainer.querySelector('a').getAttribute('href').split("/")
        const artistName = hrefArray[hrefArray.length - 1]

        const xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingArtists = JSON.parse(response.currentTarget.response);    
                let list = ''
                remainingArtists.forEach(function(artist){
                    list += `
                        <li>
                            <a href="artists/${artistName}">${artistName}</a>
                            <button class="deleteArtist">Delete</button>
                            <button class="editArtist">Edit</button>
                        </li>
                    `
                })
                artistList.innerHTML = list
            }
        }
        xhr.open("DELETE", `/api/artists?artistName=${artistName}`, true)
        xhr.send()
    }
}