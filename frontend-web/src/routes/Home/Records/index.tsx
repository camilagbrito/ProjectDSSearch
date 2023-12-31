import { useEffect, useState } from 'react';
import './style.css';
import axios from 'axios';
import { RecordsResponse } from './types';
import {formatDate} from './helpers';
import Pagination from '../../../components/Pagination';
import { Link } from 'react-router-dom';

const BASE_URL = "http://localhost:8080";


export default function Records(){

    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
    const[activePage, setActivePage] = useState(0);

    console.log(recordsResponse);
    console.log(recordsResponse?.content);

    useEffect(()=> {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
        .then(response => setRecordsResponse(response.data));
    },[activePage]);

    return(
        <div className="page-container">
            
            <div className="filters-container records-actions">
                <Link to="/charts"/>
                <button className='action-filters'>Ver gráfico</button>
            </div>
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>INSTANTE</th>
                        <th>NOME</th>
                        <th>IDADE</th>
                        <th>PLATAFORMA</th>
                        <th>GÊNERO</th>
                        <th>TÍTULO DO GAME</th>
                    </tr>
                </thead>
                <tbody>
                    {recordsResponse?.content.map(record => (
                        <tr key={record.id}>
                            <td> {formatDate(record.moment)}</td>
                            <td>{record.name}</td>
                            <td>{record.age}</td>
                            <td className='text-secondary'>{record.gamePlatform}</td>
                            <td>{record.genreName}</td>
                            <td className='text-primary'>{record.gameTitle}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Pagination 
            activePage={activePage}
            totalPages={recordsResponse?.totalPages}
            goToPage={(index:number) => setActivePage(index)} 
            />
        </div>
    );
}