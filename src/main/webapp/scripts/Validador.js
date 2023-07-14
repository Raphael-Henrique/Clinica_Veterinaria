/**
 * Validação de formulário
 * @author Raphael Henrique
 */

function validar() {

	let nome_cliente = frmConsulta.nome_cliente.value
	let nome_pet = frmConsulta.nome_pet.value

	if (nome_cliente === "") {
		alert('Preencha o campo Nome do cliente')
		frmConsulta.nome_cliente.focus()
		return false
	} else if (sobrenome === "") {
		alert('Preencha o campo Nome do pet')
		frmConsulta.nome_pet.focus()
		return false
	} else {
		documents.forms["frmConsulta"].submit()
	}
}