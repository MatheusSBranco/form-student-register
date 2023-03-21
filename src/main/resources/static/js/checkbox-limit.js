const maxSelection = 3;
const checkboxes = document.querySelectorAll('input[type="checkbox"]');
let checkedCount = 0;

checkboxes.forEach((checkbox) => {
    checkbox.addEventListener('change', (event) => {
        if (event.target.checked) {
            checkedCount++;
        } else {
            checkedCount--;
        }
        if (checkedCount > maxSelection) {
            event.target.checked = false;
            checkedCount--;
            alert("Você não pode selecionar mais que 3 opções");
        }
    });
});