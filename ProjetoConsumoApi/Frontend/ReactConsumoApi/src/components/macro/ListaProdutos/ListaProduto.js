import {Container, Row} from 'react-bootstrap'
import Produto from '../../micro/Produto/Produto'

function ListaProduto(props) {

    const produtos = props.produtos || []
    return (
        <>
            <Container>
                <Row>
                {
                    produtos.map(produto =>{
                        return (
                            <Produto key={produto.id} nome={produto.nome} foto={produto.foto} preco={produto.preco}/>
                        )
                    })
                }
                </Row>
            </Container>
        </>
    );
}

export default ListaProduto;