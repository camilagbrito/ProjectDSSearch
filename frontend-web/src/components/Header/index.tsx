import './style.css';
import logoImg from '../../assets/logo.svg';
import { Link } from 'react-router-dom';

export default function Header(){
    return(
        <header className="main-header">
          
            <img src={logoImg} />
            <Link to="/">
                <div className='logo-text'> 
                    <span className='logo-text-1'>Big Game</span>
                    <span className='logo-text-2'> Survey</span>
                </div>
            </Link>

        </header>
    )
}