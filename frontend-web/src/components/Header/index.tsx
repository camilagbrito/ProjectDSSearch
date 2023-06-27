import './style.css';
import logoImg from '../../assets/logo.svg';

export function Header(){
    return(
        <header className="main-header">
            <img src={logoImg} />
            <div className='logo-text'> 
                <span className='logo-text-1'>Big Game</span>
                <span className='logo-text-2'> Survey</span>
            </div>


        </header>
    )
}