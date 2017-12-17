import axios from 'axios';

const API_KEY = '7e8d544f194cf77ea8efcdb86955a1e5';
const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export const FETCH_WEATHER = 'FETCH_WEATHER';

export function fetchWeather(city) {
  const url = `${ROOT_URL}&q=${city},us`;
  const request = axios.get(url);

  console.log('Request:', request);

  return {
    type: FETCH_WEATHER,
    payload: request
  };
}


/*
http://api.openweathermap.org/data/2.5/forecast?appid=7e8d544f194cf77ea8efcdb86955a1e5&q=Chicago,us
*/