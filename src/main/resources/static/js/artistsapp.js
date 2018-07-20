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
                        <a href="/artists/${artist.id}">
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