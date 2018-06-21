# -*- coding: utf-8 -*-

from py4j.java_gateway import JavaGateway

gateway = JavaGateway()
liczba = gateway.entry_point.getLiczba()
print liczba