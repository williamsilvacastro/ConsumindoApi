import './Home.css'
import ListaProduto from '../../components/macro/ListaProdutos/ListaProduto'
import React, { useState, useEffect } from "react";
import axios from "axios";

function Home(props) {
    const [produtos, setProdutos] = useState([])
    
    




    useEffect(() => {
        axios.get('http://localhost:8080/produto')
            .then((response) => {
                setProdutos(response.data)
            })
            .catch((err) => {
                console.error("Ops! ocorreu um erro" + err)
            })
    }, [])

    return (
        <>
            <ListaProduto produtos={produtos}/>
        </>
    )
}

export default Home