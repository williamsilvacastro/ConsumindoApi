import { Form, Button, Container, Card, Alert } from 'react-bootstrap'
import React, { useState } from 'react'
import axios from "axios"


function CadastrarProduto(props) {

    const [name, setName] = useState('')
    const [foto, setFoto] = useState('')
    const [preco, setPreco] = useState(0)
    // Caso queira mandar um token é necessário criar um objeto com um headers com um atributo Authorization
    // vai ser necessário resgatar o token de algum jeito, no nosso projeto o nosso token será armazenado no contexto
    // const config = {
    //     headers: { Authorization: `Bearer ${token}` }
    // };
    
    // const bodyParameters = {
    //    key: "value"
    // };
    
    // Axios.post( 
    //   'http://localhost:8000/api/v1/get_token_payloads', bodyParameters, config
    // ).then(console.log).catch(console.log);


    const Cadastrar = (event) => {
        event.preventDefault();
        axios.post("http://localhost:8080/produto", { nome: name, foto: foto, preco: preco })
            .then((response) => {
                window.location.href ="http://localhost:3000/"
            })
    }
    return (
        <Container>
            <br />
            <Card>
                <Form className="m-3 p-2">
                    <Form.Group className="mb-3" >
                        <Form.Label>Nome do Produto</Form.Label>
                        <Form.Control type="name" placeholder="digite o nome do produto" onChange={(event) => { setName(event.target.value) }} value={name} />
                    </Form.Group>

                    <Form.Group className="mb-3" >
                        <Form.Label>Foto</Form.Label>
                        <Form.Control type="url" placeholder="url" onChange={(event) => { setFoto(event.target.value) }} value={foto} />
                    </Form.Group>

                    <Form.Group className="mb-3" >
                        <Form.Label>preço</Form.Label>
                        <Form.Control type="number" placeholder="preço" onChange={(event) => { setPreco(event.target.value) }} value={preco} />
                    </Form.Group>

                    <Button variant="primary" type="submit" onClick={(event) => { Cadastrar(event) }}>
                        Submit
                    </Button>

                </Form>
            </Card>
            <br />
        </Container>
    );
}

export default CadastrarProduto;