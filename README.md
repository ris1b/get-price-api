

[//]: # (RestFul API that returns the price from https://www.metal.com/Lithium-ion-Battery/202303240001)

# RestFul API description 

## End-point

**GET**  `/price`

Returns the current price of a Lithium-ion-Battery from the url: https://www.metal.com/Lithium-ion-Battery/202303240001

request params:
```
{}
```

response:
```
{
    "price" :"0.12"
}
```

success response:
```
Code : 200 OK
```

Error Response:

API will return 500 Internal Server Error response

###### -- if request to retrieve the price fails due to an unexpected error
```
{
    "error": "Failed to retrieve price
}
```

###### -- if url entered by the user is incorrect/invalid
```
{
    "error": "Check the url entered"
}
```
Note:

1. This API follows the RestFul architecture and uses the PriceController and PriceService layer. 

2. If we have requirement to store data in the future, then this code can be extended to add a repository layer.
