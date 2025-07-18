import Nav from "../components/Nav";
import { useState, useEffect } from "react";
import Axios from "axios";
import { useRouter } from "next/router";

export default function Admin() {
  const router = useRouter();

  const [model, setModel] = useState("");
  const [price, setPrice] = useState(0);
  const [image, setImage] = useState("");

  const [cars, setCars] = useState([]);

  const [selectcar, setSelectcar] = useState("");

  const getCars = () => {
    Axios.get("http://localhost:8080/cars/all", {
      headers: {
        "ngrok-skip-browser-warning": "sandesh",
      },
    }).then((res) => {
      setCars(res.data);
    });
  };

  const addListing = (e) => {
    e.preventDefault();

    Axios.post(
      "http://localhost:8080/cars/add",
      {
        model,
        bookings: [],
        pricePerDay: price,
        image,
      },
      {
        headers: {
          "ngrok-skip-browser-warning": "sandesh",
        },
      }
    )
      .then((res) => {
        setImage("");
        setModel("");
        setPrice(0);
        router.push("/");
        alert(res.data.model + " successfully added!");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const cloneListing = (carid) => {
    Axios.post(`http://localhost:8080/cars/clone/${carid}`)
      .then((res) => {
        alert(res.data.model + " successfully cloned!");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    if (localStorage.getItem("email") == null) {
      router.push("/");
    }
    getCars();
  }, []);

  return (
    <div>
      <Nav />
      <div className="flex flex-col items-center w-full">
        <h3 className="text-black font-semibold text-xl mt-[30px]">
          Admin Dashboard
        </h3>

        <form
          onSubmit={addListing}
          className="flex flex-col items-center w-full gap-7 mt-[50px]"
        >
          <h4 className="text-black font-semibold text-lg">Add Car Listing</h4>
          <input
            onChange={(e) => setModel(e.target.value)}
            className="pl-[10px] pr-[10px] h-9 w-3/6 focus:outline-none border-2 border-black rounded-md"
            type="text"
            placeholder="Enter Car Model"
          />
          <input
            onChange={(e) => setPrice(e.target.value)}
            className="pl-[10px] pr-[10px] h-9 w-3/6 focus:outline-none border-2 border-black rounded-md"
            type="number"
            placeholder="Enter Price Per Day"
          />
          <input
            onChange={(e) => setImage(e.target.value)}
            className="pl-[10px] pr-[10px] h-9 w-3/6 focus:outline-none border-2 border-black rounded-md"
            type="text"
            placeholder="Enter Image URL"
          />
          <button
            className="flex flex-col items-center justify-center cursor-pointer mb-7 w-2/6 bg-black h-9 rounded-md text-white mt-[10px]"
            type="submit"
          >
            Add Listing
          </button>
        </form>

        <div>
          <select onChange={(e) => setSelectcar(e.target.value)}>
            <option value="0">Select Car</option>
            {cars.map((car, index) => (
              <option key={index} value={car.id}>
                {car.model}
              </option>
            ))}
          </select>
          <button onClick={() => cloneListing(selectcar)}>Clone Listing</button>
        </div>
      </div>
    </div>
  );
}
