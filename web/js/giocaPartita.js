var username;

function clickCella(i, j)
{
    let url = "getValue?riga=" + i + "&colonna=" + j;
    $.get(url, function (response, status, xhr) {
        if (status == "success")
        {
            showCella(response.valore, i, j);
        }
        if (status == "error")
        {
            console.log("Error: " + xhr.status + ": " + xhr.statusText);
        }
    });
}

function showCella(valore, i, j)
{
    tmp = "#Cella_" + i + "_" + j
    
    if (valore == "-1")
    {
        $(tmp).html("&#128163;");
        $(tmp).removeClass("table-light");
        $(tmp).addClass("table-danger");
        setTimeout(() => {
            if (confirm("Hai perso! Vuoi fare una nuova partita?")) {
                window.location.assign("gioco?username="+username);
            } else {
                window.location.assign("index.html");
            }
        }, 500);
    } else
    {
        $(tmp).text(valore);
        $(tmp).removeClass("table-light");
        $(tmp).addClass("table-success");
    }
}

function test()
{
    let i = document.getElementById("SelectRiga").value;
    let j = document.getElementById("SelectColonna").value;

    let url = "getValue?riga=" + i + "&colonna=" + j;
    $.get(url, function (response, status, xhr) {
        if (status == "success")
        {
            i++;
            j++,
            $("#outputTest").text("Valore cella (" + (i) + "," + (j) + "): " + response.valore);
        }
        if (status == "error")
        {
            console.log("Error: " + xhr.status + ": " + xhr.statusText);
        }
    });
}

function showVictory()
{
    // Da non implementare
}

