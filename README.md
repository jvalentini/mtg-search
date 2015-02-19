# mtg-search

The goal of this project is to index every Magic:The Gathering card
into an ElasticSearch cluster. The cluster will use Kibana as a
front-end to provide visualization and display capabilities.

## Usage

...

## TODO

- Read in and parse the json cards
- Determine how to index each card.
  - How do we index metadata about card sets?
- Push the data into elasticsearch
  - Due to the large number of documents, adding some sort of resume capability would be good.
  - One way to decouple parsing from indexing could be using Kafka.
    - Parse a doc and produce a message to a kafka topic
    - Then, a consumer could read each message and keep track of position
    - This allows for parallelism as topics could contain multiple
    partitions and there could be a single consumer per partition.

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
