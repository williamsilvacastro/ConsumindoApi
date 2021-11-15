import { Col, Card } from 'react-bootstrap'

function Produto(props) {
    const nome = props.nome.toUpperCase() || {};
    const foto = props.foto || {};
    const preco = props.preco || {};
    return (
        <>
            <Col xxl={3} lg={4} md={6} xs={12} >
                <br />
                <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src={foto} />
                    <Card.Body>
                        <Card.Title>{nome}</Card.Title>
                        <Card.Text>
                            Some quick example text to build on the card title and make up the bulk of
                            the card's content.

                        </Card.Text>
                        <Card.Subtitle className="mb-2 text-danger">{preco}</Card.Subtitle>
                    </Card.Body>
                </Card>
                <br />
            </Col>
        </>
    );
}

export default Produto;