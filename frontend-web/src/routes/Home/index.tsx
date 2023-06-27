import './style.css';
import arrowIcon from '../../assets/arrow.svg';
import gamerImg from '../../assets/gamer.svg';

export default function Home(){
    return(

        <div className='home-container'>
            <div className='home-text'>
                <h1 className='home-text-title'>
                    Quais jogos a galera gosta mais?
                </h1>
                <h3 className='home-text-subtitle'>
                    Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo!
                </h3>
                <div className='home-actions'>
                    <button className='home-btn'>
                        QUERO SABER QUAIS SÃO
                    </button>
                    <div className='home-btn-icon'>
                        <img src={arrowIcon}/>
                    </div>
                </div>
            </div>
            <img src={gamerImg} className='home-image'/>
        </div>
    );

}