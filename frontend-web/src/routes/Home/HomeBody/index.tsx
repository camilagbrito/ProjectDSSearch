import './style.css';
import arrowIcon from '../../../assets/arrow.svg';
import gamerImg from '../../../assets/gamer.svg';
import { Link } from 'react-router-dom';

export default function HomeBody(){
    return(

        <div className='home-container'>
            <div className='home-text'>
                <h1 className='home-text-title'>
                    Quais jogos a galera gosta mais?
                </h1>
                <h3 className='home-text-subtitle'>
                    Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo!
                </h3>
                <Link to="/records">
                    <div className='home-actions'>
                        <button className='home-btn'>
                            QUERO SABER QUAIS SÃO
                        </button>
                        <div className='home-btn-icon'>
                            <img src={arrowIcon}/>
                        </div>
                    </div>
                </Link>
            </div>
            <img src={gamerImg} className='home-image'/>
        </div>
    );

}