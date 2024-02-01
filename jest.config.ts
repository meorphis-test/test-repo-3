import type { JestConfigWithTsJest } from 'ts-jest';

const config: JestConfigWithTsJest = {
  preset: 'ts-jest/presets/default-esm',
  testEnvironment: 'node',
  moduleNameMapper: {
    '^meorphis-test-2-vbs6wj$': '<rootDir>/src/index.ts',
    '^meorphis-test-2-vbs6wj/_shims/auto/(.*)$': '<rootDir>/src/_shims/auto/$1-node',
    '^meorphis-test-2-vbs6wj/(.*)$': '<rootDir>/src/$1',
  },
  modulePathIgnorePatterns: [
    '<rootDir>/ecosystem-tests/',
    '<rootDir>/dist/',
    '<rootDir>/deno/',
    '<rootDir>/deno_tests/',
  ],
};

export default config;
